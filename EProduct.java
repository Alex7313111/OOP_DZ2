public enum EProduct {

    JUICE ("Сок"),
    SUGAR ("Сахар"),
    APPLE ("Яблоко"),
    PEAR ("ГРУША"),
    PASTA ("МАКАРОНЫ"),
    MEAT ("Мясо");

    private String name;

    EProduct(String name) {

        this.name = name;
    }

    public String getTitle() {

        return name;
   }
}
