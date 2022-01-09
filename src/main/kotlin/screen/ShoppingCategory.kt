package screen

class ShoppingCategory {
    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요")
        var selectedCategory = readLine()
        //selectedCategory의 값이 널인지 또는 공백만으로 이루어졌는지 확인하기 위한 while문
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {
            // Todo 1. 장바구니로 이동
        } else {
            if(categories.contains(selectedCategory)){
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else{
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory]: 존재하지 않는 카테고리 입니다. 다시 입력해주세요")
        showCategories()
    }
}