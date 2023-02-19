import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		int cmp = book1.getAuthor().compareTo(book2.getAuthor());
		if (cmp == 0) {
			cmp = book1.getTitle().compareTo(book2.getTitle());
			if (cmp == 0) {
				cmp = Integer.compare(book1.getYear(), book2.getYear());
			}
		}
		return cmp;
		
	}
    // Implement the comparator method for books.

}