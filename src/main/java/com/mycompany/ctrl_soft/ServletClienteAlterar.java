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
 * @author Douglas
 */
@WebServlet(name = "ServletClienteAlterar", urlPatterns = {"/ServletClienteAlterar"})
public class ServletClienteAlterar extends HttpServlet {

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
            out.println("<title>Servlet ServletClienteAlterar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletClienteAlterar at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
//        String nome = request.getParameter("nomeCliente");
//        String cpf = request.getParameter("cpfCliente");
//        String telefone = request.getParameter("telefoneCliente");
//        String email = request.getParameter("emailCliente");
//        String endereco = request.getParameter("enderecoCliente");
//        String cidade = request.getParameter("cidadeCliente");
//        String uf = request.getParameter("estadoCliente");
//
//        ClienteDAO cliente = new ClienteDAO();
//        
//        cliente.setNome(nome);
//        cliente.setCpf(cpf);
//        cliente.setTelefone(telefone);
//        cliente.setEmail(email);
//        cliente.setEndereco(endereco);
//        cliente.setCidade(cidade);
//        cliente.setUf(uf);
//        cliente.setDtCadastro(new Date());
//
//        Estoque dao = new Estoque();
//        dao.cadastrarCliente(cliente);
//
//        request.setAttribute("cliente", cliente);
//
//        RequestDispatcher disp
//                = request.getRequestDispatcher("Back_end_cliente.jsp");
//        disp.forward(request, response);
        String idTexto = request.getParameter("idCliente");
        String botaoValor = request.getParameter("btn-consultar");
        int id = Integer.parseInt(idTexto);

        Cliente cliente = new Cliente();

        Estoque dao = new Estoque();
        
        if (botaoValor.equals("Pesquisar")) {
            dao.consultarCliente(cliente, id);
        }
        else {
            String nome = request.getParameter("nomeCliente");
            String cpf = request.getParameter("cpfCliente");
            String telefone = request.getParameter("telefoneCliente");
            String email = request.getParameter("emailCliente");
            String endereco = request.getParameter("enderecoCliente");
            String cidade = request.getParameter("cidadeCliente");
            String uf = request.getParameter("estadoCliente");

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);
            cliente.setCidade(cidade);
            cliente.setUf(uf);
            cliente.setDtCadastro(new Date());

            dao.alterarCliente(cliente, id);
        }

        request.setAttribute("cliente", cliente);

        RequestDispatcher disp
                = request.getRequestDispatcher("Alterar_Cliente.jsp");
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