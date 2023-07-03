package com.david.tot.domain

import com.david.tot.data.ProductRepository
import com.david.tot.domain.model.Product
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(product:Product):Int {
        return repository.updateProduct(product)
    }
}
