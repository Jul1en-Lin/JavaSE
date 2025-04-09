package Utils;


import Book.Book;

public class AnalyzingBook {
    //存储数据
    public void storeObject(Book[] books, String filename) {
        int bookUseLen = 0;
        for (int i = 0; i < books.length; i++) {
            if (books != null) {
                bookUseLen++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bookUseLen; i++) {
            if (books[i] != null) {
                stringBuilder.append(books[i].toJson());
            }
        }
    }
    //从文件读取数据
    public Book[] loadObject(Book[] books, String filename){

    }
    public Book parseBookJson(String Json){

    }




}
