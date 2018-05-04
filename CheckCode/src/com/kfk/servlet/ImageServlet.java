package com.kfk.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ImageServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bufferedImage = new BufferedImage(68, 25, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		Color color = new Color(200, 150, 255);
		graphics.setColor(color);
		graphics.fillRect(0, 0, 68, 25);
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUUWXYZ1234567890".toCharArray();
		Random random = new Random();
		int length = ch.length,index;
		StringBuffer sBuffer = new StringBuffer();
		for(int i = 0; i < 4; i++) {
			index = random.nextInt(length);
			graphics.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
			graphics.drawString(ch[index]+"", (i*15)+3, 18);
			sBuffer.append(ch[index]);
		}
		
		request.getSession().setAttribute("piccode", sBuffer.toString());
		ImageIO.write(bufferedImage, "JPG", response.getOutputStream());
	}

}
