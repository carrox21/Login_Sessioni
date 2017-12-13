import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
{
 private boolean ricerca_user(String us,String ps) throws IOException
 {
  FileReader r=new FileReader("Data.txt");
  BufferedReader rb=new BufferedReader(r);
  String s;
  String[] words=new String[2];
  s=rb.readLine();
  boolean b=false;
  int i=0;
  do
  {
   for(String temp: s.split(";"))
   {
    words[i]=temp;
    i++;
   }
   if (words[0].equals(us))
   {
    ps=words[1];
    b=true;
   }
   else
   {
    b=false;
   }
  }
  while(words[0].equals(us));
  return b; 
 }
 protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  req.getRequestDispatcher("link.html").include(req,res);
  String pass="";
  String user=req.getParameter("utente");
  String password=req.getParameter("password");
  if(ricerca_user(user,pass)==false)
  {
   out.println("<br>");
   out.println("<p>Utente non presente</p>");
  }
  else
  {
   try
   {
    if(password.equals(pass))
    {
     out.println("<br>");   
     out.println("<p>Benvenuto "+user+"</p>");   
     HttpSession session=req.getSession();
     session.setAttribute("utente",user);
    }
    else
    {
     out.print("<p>Nome utente o password errati, riprovare<p>");
     req.getRequestDispatcher("login.html").include(req,res);
    }
   }
   catch(Exception e)
   {
    out.print("Errore");
   }
  }
  out.close();
 }
}
