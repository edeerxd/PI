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
@WebServlet(name = "ServletClienteCadastrar", urlPatterns = {"/ServletClienteCadastrar"})
public class ServletClienteCadastrar extends HttpServlet {

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
        
        //Variáveis de verificação
        boolean mensagem = false;
        
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher disp
                = request.getRequestDispatcher("Cadastrar_Cliente.jsp");
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
        
        //Valores dos campos do formulário
        String nome = request.getParameter("nomeCliente");
        String cpf = request.getParameter("cpfCliente");
        String telefone = request.getParameter("telefoneCliente");
        String email = request.getParameter("emailCliente");
        String endereco = request.getParameter("enderecoCliente");
        String cidade = request.getParameter("cidadeCliente");
        String uf = request.getParameter("estadoCliente");

        //Cria um novo objeto cliente
        Cliente cliente = new Cliente();
        
        //Setando novo cliente
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setCidade(cidade);
        cliente.setUf(uf);

        //Cria objeto do tipo DAO
        ClienteDAO dao = new ClienteDAO();
        //Variável recebe resposta se cliente foi ou não cadastrado
        boolean cadastrado = dao.cadastrarCliente(cliente);
        
        //Se o cliente for cadastrado mostra mensagem de sucesso
        if (cadastrado == true) {
            boolean mensagem = true;
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp
                = request.getRequestDispatcher("Cadastrar_Cliente.jsp");
            disp.forward(request, response);
        } else {
            boolean mensagem = false;
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp
                = request.getRequestDispatcher("Cadastrar_Cliente.jsp");
            disp.forward(request, response);
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
