package utils;

import Book.Book;
import com.bit.utils.FileUtils;

public class AnalyzingBook {
    //存储书籍
    public void storeObject(Book[] books, String name, String filename) throws Exception{
        //统计有效书籍
        int BooksUseLen = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                BooksUseLen++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < BooksUseLen; i++) {
            if (books[i] != null) {
                //更改过的toString方法 原理相同
                stringBuilder.append(books[i].toJSON());
                if (i != BooksUseLen - 1) {
                    stringBuilder.append("\n");
                }
            }
        }
    }
    //每次读取书籍
    public Book[] loadObject(String filename) {
        //解析书籍
        String content = FileUtils.readFile(filename);


    }

    public static void main(String[] args) {

    }
}
