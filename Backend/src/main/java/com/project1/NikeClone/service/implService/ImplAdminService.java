package com.project1.NikeClone.service.implService;

import com.project1.NikeClone.entity.Product;
import com.project1.NikeClone.entity.ProductImage;
import com.project1.NikeClone.entity.ProductSize;
import com.project1.NikeClone.model.ProductDetail;
import com.project1.NikeClone.model.ProductSizeForm;
import com.project1.NikeClone.repository.ProductImageRepository;
import com.project1.NikeClone.repository.ProductRepository;
import com.project1.NikeClone.repository.ProductSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ImplAdminService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductSizeRepository productSizeRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public ProductDetail getProductDetail(Long id){
        String name;
        String describe;
        String caterology;
        String avata;
        Double price;

        List<String> image = new ArrayList<>();
        List<ProductSizeForm> size = new ArrayList<>();

        Product product = productRepository.findById(id).get();

        name = product.getProduct_name();
        describe = product.getProduct_describe();
        caterology = product.getProduct_caterology();
        avata = product.getProduct_avata();
        price = product.getProduct_price();

        List<ProductImage> productImage = productImageRepository.findByProductId(id);
        List<ProductSize> productSizes = productSizeRepository.findByProductId(id);

        for(ProductImage i : productImage){
            image.add(i.getProductImage_link());
        }

        for(ProductSize i : productSizes){
            size.add(new ProductSizeForm(i.getProductSize_name(),i.getProductSize_amount()));
        }

        return new ProductDetail(name, describe, caterology, avata, price, image, size);
    }

    public void addProduct(ProductDetail productDetail){
        String name =  productDetail.getName();
        String describe = productDetail.getDescribe();
        String caterology = productDetail.getCaterology();
        String avata = productDetail.getAvata();
        Double price = productDetail.getPrice();

        List<String> image = productDetail.getImage();
        List<ProductSizeForm> size = productDetail.getSize();

        Long id = productRepository.save(new Product(name, describe, caterology, avata, price)).getProduct_id();

        for(String i : image){
            productImageRepository.save(new ProductImage(id, i));
        }

        for(ProductSizeForm  i : size){
            productSizeRepository.save(new ProductSize(id, i.getSize(), i.getQuantity()));
        }
    }

    public void updateProduct(Long id, ProductDetail productDetail){
        String name =  productDetail.getName();
        String describe = productDetail.getDescribe();
        String caterology = productDetail.getCaterology();
        String avata = productDetail.getAvata();
        Double price = productDetail.getPrice();

        List<String> image = productDetail.getImage();
        List<ProductSizeForm> size = productDetail.getSize();

        productRepository.findById(id)
                .map(product -> {
                    product.setProduct_name(name);
                    product.setProduct_describe(describe);
                    product.setProduct_caterology(caterology);
                    product.setProduct_avata(avata);
                    product.setProduct_price(price);
                    return productRepository.save(product);
                });

        productSizeRepository.deleteByProductId(id);
        for(ProductSizeForm i : size){
            productSizeRepository.save(new ProductSize(id, i.getSize(), i.getQuantity()));
        }

        productImageRepository.deleteByProductId(id);
        for(String i : image){
            productImageRepository.save(new ProductImage(id, i));
        }

    }

    public void deleteProduct(Long id){
        productImageRepository.deleteByProductId(id);
        productSizeRepository.deleteByProductId(id);
        productRepository.deleteById(id);
    }
}
