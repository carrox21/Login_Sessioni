
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SaveDataServlet extends HttpServlet
{
 protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  FileWriter w=new FileWriter("Data.txt");
  req.getRequestDispatcher("link.html").include(req,res);
  String user=req.getParameter("utente");
  String password=req.getParameter("password");
  w.write(user+";"+password);
  w.close();
  out.close();
 }
}
