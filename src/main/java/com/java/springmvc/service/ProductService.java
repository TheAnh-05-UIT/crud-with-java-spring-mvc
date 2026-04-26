package com.java.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.springmvc.domain.Product;
import com.java.springmvc.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFileService uploadFileService;

    public ProductService(ProductRepository productRepository,
            UploadFileService uploadFileService) {
        this.productRepository = productRepository;
        this.uploadFileService = uploadFileService;
    }

    public List<Product> handleGetAllProduct() {
        return this.productRepository.findAll();
    }

    public Product handleCreateProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Product handleGetProductById(Long id) {
        Optional<Product> optionalProduct = this.productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    public Product handleUpdateProductById(Long id, Product productUpdate, MultipartFile file) {
        Product updateProductById = this.handleGetProductById(id);
        updateProductById.setName(productUpdate.getName());
        updateProductById.setPrice(productUpdate.getPrice());
        updateProductById.setDetailDesc(productUpdate.getDetailDesc());
        updateProductById.setShortDesc(productUpdate.getShortDesc());
        updateProductById.setQuantity(productUpdate.getQuantity());
        updateProductById.setFactory(productUpdate.getFactory());
        updateProductById.setTarget(productUpdate.getTarget());

        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            String updateFileName = this.uploadFileService.handleStorefile(file, "product");
            if (!updateFileName.equals("")) {
                updateProductById.setImage(updateFileName);
            }
        }
        return this.productRepository.save(updateProductById);
    }

    public void handleDeleteProductById(Long id) {
        Product deleteProductById = this.handleGetProductById(id);
        if (deleteProductById != null) {
            this.productRepository.deleteById(id);
        }
    }
}
