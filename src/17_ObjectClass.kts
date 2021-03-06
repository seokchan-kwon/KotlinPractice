class Button {
    init {
        println("button class init");
    }
}

object SingletonA {
    const val intValue: Int = 100;
    const val strValue: String = "SingletonA.strValue";
    val button: Button = Button();
}

println(SingletonA.intValue);
println(SingletonA.strValue);

private class SingletonB(val name: String) {

    companion object {
        private var INSTANCE: SingletonB? = null;

        fun getInstance(name: String): SingletonB = INSTANCE ?: synchronized(this) {
            INSTANCE ?: SingletonB(name).also {
                INSTANCE = it;
            }
        }

    }
}


println(SingletonB.getInstance("SingletonB").name);


SingletonA.button;