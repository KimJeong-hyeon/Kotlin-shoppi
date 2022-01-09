package screen

import data.Product

class ShoppingProductList {
    private val product = arrayOf(
        Product("패션","겨울 패딩"),
        Product("패션","겨울 바지"),
        Product("전자기기","핸드폰"),
        Product("전자기기","블루투스 이어폰"),
        Product("전자기기","노트북"),
        Product("반려동물용품","건식 사료"),
        Product("반려동물용품","습식 사료"),
        Product("반려동물용품","치약"),
        Product("반려동물용품","간식")
    )
    private val categories : Map<String, List<Product>> = product.groupBy {
        it.categoryLabel
    }

    fun showProducts(selectedCategory : String){
        val categoryProduct = categories[selectedCategory]
        if(!categoryProduct.isNullOrEmpty()) {
            println(
                """"
                |***==========================***
                |선택하신 [$selectedCategory] 카테고리 상품입니다
                |"""".trimMargin()
            )
            val productSize = categoryProduct.size
            for (index in 0 until productSize) {
                println("${index}.${categoryProduct[index].name}")
            }
        }else{
            showEmptyProductMessage(selectedCategory)
        }
    }
    private fun showEmptyProductMessage(seletedCategory : String){
        println("[$seletedCategory] 카테고리의 상품이 등록되기전입니다.")
    }
}