package Test.ATemp.BookSystem;


public class Book {
    private int BNUmber;
    private String BName;   //图书名称
    private int BTotal;     //总数
    private int BExisting;  //现存数量

    public int getBNUmber() {
        return BNUmber;
    }

    public String getBName() {
        return BName;
    }

    public int getBTotal() {
        return BTotal;
    }

    public int getBExisting() {
        return BExisting;
    }

    public void setBNUmber(int BNUmber) {
        this.BNUmber = BNUmber;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public void setBTotal(int BTotal) {
        this.BTotal = BTotal;
    }

    public void setBExisting(int BExisting) {
        this.BExisting = BExisting;
    }
}
