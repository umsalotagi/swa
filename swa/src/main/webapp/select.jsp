<%@page import="com.swapasya.domains.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.swapasya.domains.BookTitle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.swapasya.repo.*, org.springframework.context.ApplicationContext,org.springframework.context.annotation.AnnotationConfigApplicationContext,org.springframework.data.mongodb.core.MongoOperations,com.swapsya.config.*,com.swapasya.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%




BookTitleRepositoryMongoDB bktitleRepo=new BookTitleRepositoryMongoDB(DBConnect.op);
BookTitle booktTile=bktitleRepo.findOne(request.getParameter("BookTitleId"));


out.print("[");

//while(true)
//{
	out.print("{");
	
		//System.out.println("In for");
	out.print("bookTitleID"+":\'"+booktTile.getBookTitleID()+"\'");
	out.print(",");
	out.print("isbnNumber"+":\'"+booktTile.getIsbnNumber()+"\'");
	out.print(",");
	out.print("bookName"+":\'"+booktTile.getBookName()+"\'");
	out.print(",");
	out.print("authour"+":\'"+booktTile.getAuthor()+"\'");
	out.print(",");
	out.print("publication"+":\'"+booktTile.getAuthor()+"\'");
	out.print(",");
	out.print("bindingType"+":\'"+booktTile.getBindingType()+"\'");
	out.print(",");
	out.print("noOfPages"+":\'"+booktTile.getNoOfPages()+"\'");
	out.print(",");
	out.print("language"+":\'"+booktTile.getLanguage()+"\'");
	out.print(",");
	out.print("imgPath"+":\'"+booktTile.getImgPath()+"\'");
	out.print(",");
	ArrayList<String> tags=booktTile.getTags();
	out.print("[");
	out.print("{");
	out.print("tags"+":\'");
	for(int i=0;i<tags.size();i++){
	out.print(tags.get(i)+"\'");
	if(i<tags.size())
	{
		out.print(",");
	}
		
	}
	out.print("}");
	out.print("]");
	
	out.print("}");
	out.print("]");
	
	//}
	
%>
</body>
</html>