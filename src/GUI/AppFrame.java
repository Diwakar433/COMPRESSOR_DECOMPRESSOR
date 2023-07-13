package GUI;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import COM_DECOMP.compressor;
import COM_DECOMP.decompressor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

	JButton compressButton;
	JButton decompressButton;
	
//	constructor of AppFrame
	
	
	AppFrame(){
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Add Button for compress
		compressButton = new JButton("Select file to compress");
		compressButton.setBounds(20, 100, 200, 30);
		compressButton.addActionListener(this);
//		Add button for decompress
		decompressButton = new JButton("Select file to decompress");
		decompressButton.setBounds(250, 100, 200, 30);
		decompressButton.addActionListener(this);
		this.add(compressButton);
		this.add(decompressButton);
		this.setSize(1000, 500);
		this.getContentPane().setBackground(Color.BLUE);
		this.setVisible(true);
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == compressButton) {
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try {
					compressor.method(file);
				}
				catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
		
		if(e.getSource() == decompressButton) {
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try {
					decompressor.method(file);
				}
				catch(Exception ee){
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
		
	}
	
	
}
