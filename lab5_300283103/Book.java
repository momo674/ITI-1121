public class Book {
	private String author;
	private String title;
	private int year;
    // Your variables declaration here

    public Book (String author, String title, int year) {
        this.author = author;
		this.title = title;
		this.year = year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object other) {
        if (this == other) {return true;}
		else if (other == null) {return false;}
        
		
		else{
			if (other instanceof Book ){
				Book o = (Book) other;
				if (o.getAuthor() == null && this.getAuthor() == null) {return true;}
				if (o.getTitle() == null && this.getTitle() == null) {return true;}
				
				
				if (this.getAuthor() == null) {return false;}
				if (this.getTitle() == null) {return false;}
				if (o.getAuthor() == null) {return false;}
				if (o.getTitle() == null) {return false;}
				if (this.getAuthor().equals(o.getAuthor())){
					if (this.getTitle().equals(o.getTitle())){
						if (this.getYear() == o.getYear()){
							return true;
						}
					}
				}
				
			}
			else{
				return false;
			}
		}
		return false;
    }

    public String toString() {
		return this.author + ":" + this.title + ":" + Integer.toString(this.year);
    }
}