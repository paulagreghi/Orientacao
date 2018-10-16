package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Orientacao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AndreEndo
 */
public class OrientacaoServlet extends HttpServlet {

    Orientacao ori;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Orientações</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Bem-vindo " + request.getSession().getAttribute("usuario") + "</h3>");
            out.println("<div>");
            out.println("<form action=\"Orientacao\" method=\"post\">");
            out.println("<label for=\"nome\">Tema</label>");
            out.println("<input type=\"text\" id=\"tema\" name=\"tema\">");
            out.println("<label for=\"nome\">Aluno</label>");
            out.println("<input type=\"text\" id=\"aluno\" name=\"aluno\">");
            out.println("<label for=\"nome\">Professor</label>");
            out.println("<input type=\"text\" id=\"professor\" name=\"professor\">");
            out.println("<button type=\"submit\" />Cadastrar</button>");
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div>");
            out.println("<ul>");
            //for(){}
            out.println("</ul>");
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(!session.getAttribute("usuario").toString().isEmpty()){
            processRequest(request, response);
        }else{
            response.sendRedirect("Login");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        HttpSession session = request.getSession();
        
        if(!session.getAttribute("usuario").toString().isEmpty()){
            String tema = request.getParameter("tema");
            String aluno = request.getParameter("aluno");
            String professor = request.getParameter("professor");

            if(!tema.isEmpty() && !aluno.isEmpty() && !professor.isEmpty()){
                ori = new Orientacao(tema, aluno, professor);
            }
            processRequest(request, response);
        } else {
            response.sendRedirect("Login");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
