/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eder Rodrigues
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        boolean mensagem = false;

        request.setAttribute("mensagem", mensagem);

        RequestDispatcher disp
                = request.getRequestDispatcher("cadastroProduto.jsp");
        disp.forward(request, response);
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
        processRequest(request, response);
//        ProdutoDAO dao = new ProdutoDAO();
//        List<Produto> listaP = dao.listarProdutos();
//
//        request.setAttribute("produtos", listaP);
//
//        RequestDispatcher disp
//                = request.getRequestDispatcher("Listar.jsp");
//        disp.forward(request, response);
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
        
        //Pega os parametros dos Input do usuario
        String nome = request.getParameter("nomeProduto");
        String marca = request.getParameter("marcaProduto");
        double preco = Double.valueOf(request.getParameter("precoProduto"));
        int qtde = Integer.valueOf(request.getParameter("qtdeProduto"));
        long idfilial = Long.valueOf(request.getParameter("idfilial"));
        //Cria uma variável do tipo Produto
        Produto p1 = new Produto();
        //Seta a variável com os parametros do usuário
        p1.setId_filial(idfilial);
        p1.setNome(nome);
        p1.setMarca(marca);
        p1.setPreco(preco);
        p1.setQtde(qtde);
        p1.setDtCadastro(new Date());
        //Criação da variável responsável por chamar o método de produto
        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrarProduto(p1);
        //Boolean para confirmar se o cadastro foi realizado com êxito
        boolean mensagem = true;
        //atribuindo a variavel para jsp com o boolean
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher disp
                = request.getRequestDispatcher("cadastroProduto.jsp");
        disp.forward(request, response);

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
