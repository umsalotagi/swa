package com.swapasya.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.mongodb.core.MongoOperations;

import com.swapasya.domains.AssignList;
import com.swapasya.domains.Book;
import com.swapasya.domains.BookTitle;
import com.swapasya.domains.WaitList;
import com.swapasya.model.DBConnect;
import com.swapasya.repo.BookTitleRepositoryMongoDB;

@WebServlet("/myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		response.getWriter().println("Hello, Welcome to Spring MongoDB !!! General");
		
		String btn=request.getParameter("sbtn");
		
		System.out.println(btn + " response");
		
		if("btn1".equals(btn))
		{
			callingBtn1(request, response);
		}
		else if("btn2".equals(btn))
		{
			callingBtn2();
		}
		else if("btn3".equals(btn))
		{
			callingBtn3();
		}
		else if("btn4".equals(btn))
		{
			callingBtn4();
		}
		else if("btn5".equals(btn))
		{
			callingBtn5();
		}
		else if("btn6".equals(btn))
		{
			callingBtn6();
		}
		else if("btn7".equals(btn))
		{
			callingBtn7();
		}
		else if("btn8".equals(btn))
		{
			callingBtn8();
		}
		else if("btn9".equals(btn))
		{
			callingBtn9();
		}
		else if("btn10".equals(btn))
		{
			callingBtn10();
		}
		
	}
	
	
	
	void callingBtn1(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{	
		System.out.println("Pressed Button one ...");
		MongoOperations op=DBConnect.getConnection();
		BookTitleRepositoryMongoDB mdb=new BookTitleRepositoryMongoDB(op);
		
		ArrayList<String> tags=new ArrayList<>();
		tags.add("Self Help");
		tags.add("Mythology");
		
		BookTitle bt = new BookTitle("BT012", "9380658745", "The Immortals of Meluha (Shiva Trilogy) 2"
				, "Amish Tripathi", "Westland", "Paperback", tags, 415, "English" );
		
		ArrayList<String> tags2=new ArrayList<>();
		tags2.add(".net");
		tags2.add("ASP");
		mdb.insertOne(bt);
		
		BookTitle bkTitle=new BookTitle(".Net2", "1232u348", "Pro ASP.NET Core MVC 2", "Adam Freeman","XXX", "Folded",tags2 , 2000, "English" );
		
		mdb.insertOne(bkTitle);
		
		
		Iterable<BookTitle> it = mdb.findAll();
		for (BookTitle bb : it) {
			System.out.println(bb.getBookName() + " " + bb.getBookTitleID());
		}
	}
	
	void callingBtn2()
	{
		System.out.println("Pressed Button two ...");
		MongoOperations op=DBConnect.getConnection();
		BookTitleRepositoryMongoDB mdb=new BookTitleRepositoryMongoDB(op);

		List <BookTitle> btL =  mdb.findByAuthor("Amish Tripathi");
		
		Date pd = new Date();
		
		Book b = new Book("BT01.1", pd, 300, "Book");
		Book b1 = new Book("BT01.2", pd, 400, "Book");
		Book b2 = new Book("BT01.3", pd, 500, "Book");
		
		btL.get(1).addBook(b);
		btL.get(1).addBook(b1);
		btL.get(1).addBook(b2);
		
		List <Book> bs = btL.get(1).getBooks();
		for (Book bb : bs) {
			System.out.println(bb.getBookID());
			System.out.println(bb.getPrice());
		}
		
		System.out.println(btL.get(0).getIsbnNumber());
		

		mdb.save(btL.get(0));
		
	}
	void callingBtn3()
	{
		System.out.println("Pressed Button three ...");
		MongoOperations op=DBConnect.getConnection();
		BookTitleRepositoryMongoDB mdb=new BookTitleRepositoryMongoDB(op);
		
		List<BookTitle> bt = mdb.findByAuthor("Amish Tripathi");
		for (BookTitle bb : bt) {
			System.out.println(bb.getBookTitleID());
		}
	}
	void callingBtn4()
	{
		
	}
	void callingBtn5()
	{
		
	}
	void callingBtn6()
	{
		
	}
	void callingBtn7()
	{
		
	}
	void callingBtn8()
	{
		
	}
	void callingBtn9()
	{
		
	}
	void callingBtn10()
	{
		System.out.println("Button 10 called");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void old () {
		
		MongoOperations op=DBConnect.getConnection();
		BookTitleRepositoryMongoDB mdb=new BookTitleRepositoryMongoDB(op);
		
		ArrayList<String> tags=new ArrayList<>();
		tags.add(".net");
		tags.add("ASP");
		
		
		List<Book> books=new ArrayList<>();
		Book book=new Book("b001",new Date(12, 10, 2016), 800, "xx");
		Book book1=new Book("b002",new Date(11, 10, 2016), 800, "xx");
		books.add(book);
		books.add(book1);
		
		
		List<WaitList> waitList=new ArrayList<>();
		List<AssignList> assignList=new  ArrayList<>();
		
		
		BookTitle bkTitle=new BookTitle(".Net", "1232u348", "Pro ASP.NET Core MVC", "Adam Freeman","XXX", "Folded",tags , 2000, "English" );
		
		bkTitle.setBooks(books);
		bkTitle.setWaitList(waitList);
		bkTitle.setAssignList(assignList);
		
		mdb.insertOne(bkTitle);
		System.out.println("Inserted Successfully");
	}
	
	public void add1 () throws ClassNotFoundException {
		
		ReadTxt r = new ReadTxt();
		ArrayList<ArrayList<String>>  data = r.readT("data/catalogue.txt");
		
	}
	
	public void add2 () throws ClassNotFoundException {
		
		ReadTxt r = new ReadTxt();
		ArrayList<ArrayList<String>>  data = r.readT("data/catalogue.txt");
		
	}
	
	public void addBook () {
		
	}
	
	
	

	String[] bookss = {"B01","B02", "B03","B04", "B05","B06","B07","B08","B09","B10", "B11","B12", "B13","B14", "B15",
			"B16","B17","B18","B19","B20", "C01","C02", "C03","C04", "C05","M01","M02", "M03","M04", "M05",};
	
	// 8
	String[] studentt = { "161117" , "161118" ,"161119", "161120", "161121" , "161122", "161123" , "161124"};
	
	String[] issueType = { "BookBank", "GATE" , "Topper"};
	
	public void testCase(GeneralFinal gen, Date d , int noOfSteps) {
		
		// Create 3 category, 2 roles , 2 issue , freeissue,
		
		//String personRole, String bookCategory, int dayLimitForEachBook,  int bookQuantityLimit
		//students , books ..
		ArrayList <Integer> st = new ArrayList <Integer>();
		ArrayList <Integer> bk = new ArrayList <Integer>();
		
		
		
		
		for (int i=0; i<noOfSteps; i++) {
			//int issueTypeTrue = (int) getRandomInt (0, 2);
			int issueTypeTrue = 1;
			int issueTypeIndex = (int) getRandomInt (0, 3);
			System.out.println("index " + issueTypeTrue + " " + issueType[issueTypeIndex]);
			int S1 = (int) getRandomInt (0, 8);
			int B2 = (int) getRandomInt (0, 15);
			st.add(S1);
			bk.add(B2);
			
			gen.issueBookByCategory(studentt[S1], bookss[B2], d);
			
			if (issueTypeTrue==1) {
				gen.issueBookByIssueType(studentt[S1], bookss[B2], d, issueType[issueTypeIndex]);
				System.out.println(bookss[B2] + " to " +  studentt[S1]+" " + issueType[issueTypeIndex] + " issue type issued");
			} else {
				System.out.println(bookss[B2] + " to " +  studentt[S1]+ " issued");
			}
	
			sleep(50);
			
			
		}
		
		
		for (int i=0; i<st.size(); i++) {
			
			int k1 = st.get(i);
			int k2 = bk.get(i);
			
			gen.allReturn(studentt[k1], bookss[k2], d);
			
			System.out.println(bookss[k2] + " return " +  studentt[k1]+ " ");
		}
		
	}
	
	public void sleep (int mi) {
		try {
			Thread.sleep(mi);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public long getRandomInt ( int minimum , int maximum) {
		  return (minimum + (int)(Math.random() * maximum)); 
	  }
	
	
	
	ArrayList <ArrayList <String>> textDb;
	
	// wehn there is new file add it to path :
	//it has to add to :
		//      GUmeshPro\war\WEB-INF\classes\   your file
	
	public void createBookFromCSV (GeneralFinal gen) throws ClassNotFoundException {
		
		textDb = new ReadTxt ().readT ("\\TB.csv");
		textDb.get(0).get(0);
		
		StringBuffer s = new StringBuffer();
			

		
	}
	
	public void setRules (GeneralFinal gen) {

	}
		

}
