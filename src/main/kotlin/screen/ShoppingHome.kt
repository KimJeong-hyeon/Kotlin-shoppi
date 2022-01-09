package screen

class ShoppingHome {
    fun start(){
        showWelcomeMessage()
        showCategories()
    }

    private fun showWelcomeMessage() {
        println("안녕하세요 shoppi에 오신걸 환영합니다")
        println("쇼핑을 계속 하시려면 이름을 입력해주세요:")
        val name = readLine()
        println(
            """"
            |감사합니다. 반갑습니다, $name 님
            |원하시는 카테고리를 입력해주세요
            |***===========================***
            """.trimMargin()
        )
    }

    private fun showCategories() {
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
            //Todo 2. 카테고리 상품 목록 보여주기
            //Todo 3. 카테고리 목록에 없는 값을 입력한 경우
        }
    }
}