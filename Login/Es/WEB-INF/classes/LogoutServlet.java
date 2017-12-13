import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet
{
 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  req.getRequestDispatcher("link.html").include(req,res);
  HttpSession session=req.getSession();
  session.invalidate();
  out.println("<p>Disconnessione all'accunt riuscita</p>");
  out.close();
 }
}
