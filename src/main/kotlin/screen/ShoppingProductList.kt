package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extension.getNotEmptyInt
import extension.getNotEmptyString

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
                |$LINE_DIVIDER
                |선택하신 [$selectedCategory] 카테고리 상품입니다
                |"""".trimMargin()
            )
            categoryProduct.forEachIndexed { index, product ->
                println("${index}.${product.name}")
            }
            showCartOption(categoryProduct,selectedCategory)
        }else{
            showEmptyProductMessage(selectedCategory)
        }
    }
    private fun showEmptyProductMessage(seletedCategory : String){
        println("[$seletedCategory] 카테고리의 상품이 등록되기전입니다.")
    }
    private fun showCartOption(categoryProduct:List<Product>, seletedCategory: String){
        println(
            """
            $LINE_DIVIDER
            장바구니에 담을 상품 번호를 선택해주세요.
        """.trimIndent()
        )
        val selectedIndex = readLine().getNotEmptyInt()
        categoryProduct.getOrNull(selectedIndex)?.let {
            CartItems.addProduct(it)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *를 입력해주세요")
            val answer = readLine().getNotEmptyString()
            if(answer == "#"){
                val shoppingCart =ShoppingCart()
                shoppingCart.showCartItems()
            }else if(answer == "*"){
                showProducts(seletedCategory)
            }else{
                //Todo 그 외의 값을 입력한 경우
            }
        }
    }
}