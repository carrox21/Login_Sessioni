import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ProfileServlet extends HttpServlet
{
 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  req.getRequestDispatcher("link.html").include(req,res);
  HttpSession session=req.getSession(false);
  if(session!=null)
  {
   String user=(String)session.getAttribute("utente");
   out.println("<p>Ciao "+user+" Benvenuto nel tuo profilo</p>");
  }
  else
  {
   out.println("<p>Bisogna prima autenticarsi tramite il login</p>");
   req.getRequestDispatcher("login.html").include(req,res);
  }
  out.close();
 }
}
