// // /* *
// //  * Use static array for NewsFeed
// //  * with constant MAX_SIZE
// //  * */

// // public class NewsFeed {

// //     private Post[] messages;
// //     private int size;
// //     public static final int MAX_SIZE = 25;

// //     public NewsFeed() {
// //     	messages = new Post[MAX_SIZE];
// // 		size = 0;
// //     }

// //     public void add(Post message) {
// // 		if (size < MAX_SIZE){
// // 			messages[size] = message;
// // 			size++;
// // 		}
// //     }

// //     public Post get(int index) {
// // 	     return messages[index];
// //     }

// //     public int size() {
// // 	     return size;
// //     }

// // 	  public void sort(){
// // 			int i, j, argMin;
// // 			Post tmp;
// // 			for (i = 0; i < size - 1; i++) {
// // 				argMin = i;
// // 				for (j = i + 1; j < size(); j++) {
// // 					if (messages[j].compareTo(messages[argMin]) < 0) {
// // 						argMin = j;
// // 					}
// // 				}

// //   			tmp = messages[argMin];
// //   			messages[argMin] = messages[i];
// //   			messages[i] = tmp;
// // 		  }

// // 	  }

// //   	public NewsFeed getPhotoPost(){
// // 		NewsFeed newsFeedphot = new NewsFeed();
// // 		Post [] postArrayTemp = new Post[MAX_SIZE];
// // 		for(int i=0;i<messages.length ;i++){
// // 		if(messages[i] instanceof PhotoPost){
// // 		postArrayTemp[0] = messages[i];
// // 		}
// // 		}
// // 		newsFeedphot.setPostArray(postArrayTemp);
// // 		return newsFeedphot;
// // 		}

// //   	public NewsFeed plus (NewsFeed newsfeed){
// // 		NewsFeed newsFeedphot = new NewsFeed();
// // 		Post [] postArrayTemp = new Post[MAX_SIZE];
// // 		for(int i=0;i<newsfeed.getPostArray().length ;i++){
// // 		this.addPostMessage(newsfeed.getPostArray()[i]) ;
// // 		}
// // 		this.sortMessages();
// // 		return newsFeedphot;
// // 		}
		

// // }


// import java.util.Arrays;
// import java.util.Collections;


// public class NewsFeed {

// public static final int MAX_SIZE = 25;

// private Post[] postArray ;
// private int count ;

// public NewsFeed(){

// postArray = new Post[MAX_SIZE];
// count =0;

// }
// // method for adding a Post message. The message is added after the last message added.
// public void addPostMessage(Post post){
// postArray[count] = post;
// this.count++;

// }

// //method sort in which the Post are sorted from the oldest to the most recent.
// public void sortMessages(){
// Collections.sort( Arrays.asList(postArray));
// }
// //method for returning the message found at a given index
// public Post get(int index){
// return postArray[index];
// }


// //returns the number of messages currently stored
// public int size(){

// return this.count;
// }
// //method getPhotoPost that returns a new object of type NewsFeed containing only the PhotoPost
// public NewsFeed getPhotoPost(){
// NewsFeed newsFeedphot = new NewsFeed();
// Post [] postArrayTemp = new Post[MAX_SIZE];
// for(int i=0;i<postArray.length ;i++){
// if(postArray[i] instanceof PhotoPost){
// postArrayTemp[0] = postArray[i];
// }
// }
// newsFeedphot.setPostArray(postArrayTemp);
// return newsFeedphot;
// }

// //returns a new object of type NewsFeed that represents the combination of the two NewsFeed after sorting
// public NewsFeed plus (NewsFeed newsfeed){
// NewsFeed newsFeedphot = new NewsFeed();
// Post [] postArrayTemp = new Post[MAX_SIZE];
// for(int i=0;i<newsfeed.getPostArray().length ;i++){
// this.addPostMessage(newsfeed.getPostArray()[i]) ;
// }
// this.sortMessages();
// return newsFeedphot;
// }

// public Post[] getPostArray() {
// return postArray;
// }
// public void setPostArray(Post[] postArray) {
// this.postArray = postArray;
// }
// public int getCount() {
// return count;
// }
// public void setCount(int count) {
// this.count = count;
// }
// public static int getMaxSize() {
// return MAX_SIZE;
// }
// }


import java.util.Arrays;

import java.util.Comparator;

public class NewsFeed

{

// Declare the necessary class variables

private Post post_list[];

private final int MAX_SIZE = 25;

private int curr_size;

// Constructor for the class

public NewsFeed()

{

// Initialize the array

post_list = new Post[MAX_SIZE];

// Set current size as 0

curr_size = 0;

}

// Define the addPost() method

public void add(Post message) {
		if (curr_size < MAX_SIZE){
			post_list[curr_size] = message;
			curr_size++;}
}

public void addPost(Post p)

{

// Check if curr_size is less than the MAX_SIZE

if(curr_size < MAX_SIZE )

{

// Add the post to the array post_list

post_list[curr_size] = p;

// Increment curr_size by 1

curr_size++;

}

}

// Define the sort() method

public void sort()

{

for(int x = 1; x < curr_size; x++)

{

// Call the compareTo() method to compare the timestamp

// of the posts

if(post_list[x].compareTo(post_list[x-1]) < 0)

{

// Swap the objects, accordingly

Post temp = post_list[x-1];

post_list[x-1] = post_list[x];

post_list[x] = temp;

}

}

}

// Define the getPost() method

public Post getPost(int index)

{

// Check if the value at index is less than curr_size

if(index < curr_size)

{

// return the post at the index

return post_list[index];

}

return null;

}

// Define the size() method

public int size()

{

// Return the current size of the array

return curr_size;

}

// Define the getPhotoPost() method

public NewsFeed getPhotoPost()

{

// Create an object of NewsFeed class

NewsFeed photoFeed = new NewsFeed();

// Loop till the end of the post_list

for(int x = 0; x < curr_size; x++)

{

// Check if post_list contains object of PhotoPost class

if(post_list[x] instanceof PhotoPost)

{

// Add the object of PhotoPost to NewsFeed object

photoFeed.addPost(post_list[x]);

}

}

// Return the object

return photoFeed;

}

// Define the plus() method
public Post get(int index){
return post_list[index];
}

public NewsFeed plus(NewsFeed newsfeed)

{

// Create an object of NewsFeed class

NewsFeed combinedFeed = new NewsFeed();

// Loop for this NewsFeed

for(int x = 0; x < this.curr_size; x++)

{

// Add the NewsFeed object to the combined feed object

combinedFeed.addPost(this.getPost(x));

// Sort the news feed

combinedFeed.sort();

}

// Loop for other NewsFeed

for(int x = 0; x < newsfeed.curr_size; x++)

{

// Add the NewsFeed object to the combined feed object

combinedFeed.addPost(newsfeed.getPost(x));

// Sort the news feed

combinedFeed.sort();

}

return combinedFeed;

}

}