package com.als.frm.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ImageRandomCodeServlet extends HttpServlet {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 高度
    private int width = 90;

    // 宽度
    private int height = 20;
    
    // session的名称
    private String sessionName = "imageRandomCode";

    /**
     * 传入的接口数据
     * @param req
     */
    private void setParam(HttpServletRequest req){
    	String w = req.getParameter("w");//图片宽度
    	String h = req.getParameter("h");//图片高度
    	String n = req.getParameter("n");//验证码的session的Key

    	try {
			if(w != null){
				width = Integer.valueOf(w);
			}
			if(h != null){
				height = Integer.valueOf(h);
			}
			if(sessionName != null){
				sessionName = n;
			}
		} catch (NumberFormatException e) {
			width = 90;
			height = 20;
		}
    }
    
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
    	
    	setParam(req);
    	
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        Random random = new Random();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 设置字体
        Font font = new Font("Times New Roman", Font.BOLD, 24);
        g.setFont(font);
        // 画边框
        g.setColor(Color.WHITE);
        g.drawRect(0, 10, width - 1, height - 1);

        g.setColor(Color.GRAY);
        // 随机产生干扰线
        for (int i = 0; i < 24; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(2);
            int y1 = random.nextInt(2);
            g.drawLine(x, y, x + x1, y + y1);
        }
        // 数字字母集合
        char[] numbersAndLettersStore = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
                .toCharArray();
        String randomCode = "";
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < 4; i++) {
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            String tem = String.valueOf(numbersAndLettersStore[random
                    .nextInt(62)]);
            randomCode += tem;
            g.drawString(tem, 15 * i + 16, height - 10);
        }
        // 验证码保存到Session范围
        HttpSession session = req.getSession();
        session.setAttribute(sessionName, randomCode.toString());
        // 禁止缓存
        resp.setHeader("Prama", "no-cache");
        resp.setHeader("Coche-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        // 将图像输出到
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }
}
