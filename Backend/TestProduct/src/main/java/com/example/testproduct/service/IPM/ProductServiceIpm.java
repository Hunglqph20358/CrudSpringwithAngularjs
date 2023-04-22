package com.example.testproduct.service.IPM;

import com.example.testproduct.dto.ProductDTO;
import com.example.testproduct.dto.ProductView;
import com.example.testproduct.exception.ProductException;
import com.example.testproduct.model.Brand;
import com.example.testproduct.model.Product;
import com.example.testproduct.model.ProductBrand;
import com.example.testproduct.model.ProductBrand_Id;
import com.example.testproduct.model.Status;
import com.example.testproduct.model.SubCategory;
import com.example.testproduct.repository.BrandRepository;
import com.example.testproduct.repository.ProductBrandRepository;
import com.example.testproduct.repository.ProductRepository;
import com.example.testproduct.repository.StatusRepository;
import com.example.testproduct.repository.SubCateRepository;
import com.example.testproduct.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceIpm implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SubCateRepository subCateRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ProductBrandRepository productBrandRepository;

    @Override
    public List<ProductView> getAllProduct() {
        List<ProductView> listNew = new ArrayList<>();
        for (Product p : productRepository.findAll()) {
            ProductView productView = new ProductView();
            productView.setId(p.getId());
            productView.setProductName(p.getProductName());
            ProductBrand productBrand = productBrandRepository.findBrandById(p.getId());
            Brand brand = null;
            if(productBrand == null){
                 brand = brandRepository.fillByID(Long.valueOf(1));
            }else{
                brand = brandRepository.fillByID(productBrand.getBrandId());
            }
            productView.setPrice(p.getOriginPrice());
            productView.setBrandName(brand.getBrandName());
            productView.setSubCategory(p.getSubCategory().getSubName());
            productView.setStatus(p.getStatusId().getStatusName());
            listNew.add(productView);
        }
        return listNew;
    }

    @Override
    public List<ProductView> seachProduct(String productName) {
        List<Product> pro = productRepository.seachProductByName(productName);
        List<ProductView> listView = new ArrayList<>();
        for (Product p : pro) {
            ProductView productView = new ProductView();
            productView.setId(p.getId());
            productView.setProductName(p.getProductName());
            ProductBrand productBrand = productBrandRepository.findBrandById(p.getId());
            Brand brand = null;
            if (productBrand == null) {
                brand = brandRepository.fillByID(Long.valueOf(1));
            } else {
                brand = brandRepository.fillByID(productBrand.getBrandId());
            }
            productView.setPrice(p.getOriginPrice());
            productView.setBrandName(brand.getBrandName());
            productView.setSubCategory(p.getSubCategory().getSubName());
            productView.setStatus(p.getStatusId().getStatusName());
            listView.add(productView);

        }
        return listView;
    }

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Product pro = productRepository.findProductByName(productDTO.getProductName());
        if(productDTO.getProductName().length() <= 100)
        if (pro == null) {
            Product p = new Product();
            SubCategory sub = subCateRepository.fillByID(productDTO.getSubCategoryId());
            Status status = statusRepository.fillByID(productDTO.getStatusId());
            p.setProductName(productDTO.getProductName());
            p.setColor(productDTO.getColor());
            p.setQuantity(productDTO.getQuantity());
            p.setDesciption(productDTO.getDesciption());
            p.setSellPrice(productDTO.getSellPrice());
            p.setOriginPrice(productDTO.getOriginPrice());
            p.setSubCategory(sub);
            p.setStatusId(status);
            return productRepository.save(p);
        }
        throw new ProductException("Tên Product đã tồn tại !");
    }

    @Override
    public void deleteProduct(Long id) {
        ProductBrand productBrand = productBrandRepository.findBrandById(id);
        if(productBrand == null){
            productRepository.deleteById(id);
        }else{
            ProductBrand_Id productBrandId = new ProductBrand_Id(id,productBrand.getBrandId());
            productBrandRepository.deleteById(productBrandId);
            productRepository.deleteById(id);
        }
    }

    @Override
    public ProductDTO detailProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        ProductBrand productBrand = productBrandRepository.findBrandById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.get().getId());
        productDTO.setProductName(product.get().getProductName());
        productDTO.setColor(product.get().getColor());
        productDTO.setDesciption(product.get().getDesciption());
        productDTO.setQuantity(product.get().getQuantity());
        productDTO.setSellPrice(product.get().getSellPrice());
        productDTO.setOriginPrice(product.get().getOriginPrice());
        productDTO.setStatusId(product.get().getStatusId().getId());
        if (productBrand != null) {
            productDTO.setBrandId(productBrand.getBrandId());
        } else {
            productDTO.setBrandId(Long.valueOf(1));
        }
        productDTO.setSubCategoryId(product.get().getSubCategory().getId());

        return productDTO;
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
//        Product pro = productRepository.findProductByName(productDTO.getProductName());
//        if (pro == null) {
            Product p = new Product();
            p.setId(id);
            Status status = statusRepository.fillByID(productDTO.getStatusId());
            SubCategory sub = subCateRepository.fillByID(productDTO.getSubCategoryId());
            p.setColor(productDTO.getColor());
            p.setProductName(productDTO.getProductName());
            p.setQuantity(productDTO.getQuantity());
            p.setOriginPrice(productDTO.getOriginPrice());
            p.setSellPrice(productDTO.getSellPrice());
            p.setStatusId(status);
            p.setSubCategory(sub);
            return productRepository.save(p);
    }

}
