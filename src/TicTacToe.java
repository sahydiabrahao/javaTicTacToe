import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	//ESTILO...............................................................
	ImageIcon 	image 				= new ImageIcon("./src/tictactoe.png");
	
	int			corLabelBackground	= 0x000000;  //
	int			corLabelFont		= 0x00FF00;  //
	int			corButtonBackground	= 0x444000;  //
	int			corButton			= 0x000110;	 //BOTÃO
	
	Dimension	windowDimension = new Dimension (400, 400);	
	Dimension	panelDimension 	= new Dimension (200,20);
	Dimension	labelDimension 	= new Dimension (200,20);
	Dimension	buttonDimension = new Dimension (98,20);

	Font 		labelFont 		= new Font("MV Boli", Font.BOLD, 40);
	Font 		buttonFont 		= new Font("MV Boli", Font.BOLD, 60);
	
	//VARIAVEIS...................................................................
	Random 		random 			= new Random();
	JFrame 		frame 			= new JFrame();
	JPanel 		title_panel 	= new JPanel();
	JPanel 		button_panel	= new JPanel();
	JLabel 		textField		= new JLabel();
	JButton[] 	buttons 		= new JButton[9];
	boolean		player1_turn;	
	
	
	//CONSTRUTOR...................................................................
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//BOTÃO DE FECHAR
		frame.setTitle("Tic Tac Toe");							//TÍTULO		
		frame.setSize(windowDimension);							//DIMENSÃO
		frame.setLayout(new BorderLayout());					//BORDER LAYOUT
		frame.setLocationRelativeTo(null);						//JANELA APARECE NO MEIO DA TELA
		frame.setIconImage(image.getImage());					//ICONE
		
		//RÓTULO...................................................................
		textField.setBackground(new Color(corLabelBackground));
		textField.setForeground(new Color(corLabelFont));
		textField.setFont(labelFont);
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		//PAINEL...................................................................
		title_panel.setLayout(new BorderLayout());	
		title_panel.setBounds(0,0,400,50);	
		
		//BOTOES...................................................................
		button_panel.setLayout(new GridLayout(3,3));	
		button_panel.setBackground(new Color(corButtonBackground));
		
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(buttonFont);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		//ADICIONA A TELA.........................................................
		title_panel.add(textField);								//LABEL DENTRO DO PANEL
		frame.add(title_panel, BorderLayout.NORTH);				//PANEL NO NORTH
		frame.add(button_panel);
		frame.setVisible(true);									//VISIBILIDADE	
		
		//CHAMA MATEODO.........................................................
		firstTurn();
	}
	
	//ACTION LISTENER..............................................................
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {					//LOOP PARA i ATÉ 9
			if(e.getSource() == buttons[i]) {			//CHECA SE CADA BOTÃO FOI CLICADO
				if (player1_turn) {						// P1 = TRUE ENTÃO...
					if(buttons[i].getText()=="") {		//VERIFICA SE O BOTÃO ESTÁ VAZIO X/O
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("X");
						player1_turn = false;
						textField.setForeground(Color.BLUE);
						textField.setText("Jogador O");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {		//VERIFICA SE O BOTÃO ESTÁ VAZIO X/O
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("O");
						player1_turn = true;
						textField.setForeground(Color.RED);
						textField.setText("Jogador X");
						check();
					}
				}
			}
		}
	}
	
	//METODOs......................................................................
	public void firstTurn() {
		
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textField.setForeground(Color.RED);
			textField.setText("Jogador X");
			
		}
		else {
			player1_turn = false;
			textField.setForeground(Color.BLUE);
			textField.setText("Jogador O");
		}
	}
	public void check() {
		//VERIFICA WIN X .............................................................
		if(		(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(		(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(		(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(		(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(		(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(		(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(		(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(		(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//VERIFICA WIN 0 .............................................................
		if(		(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(		(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(		(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(		(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(		(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(		(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(		(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(		(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false); 			//DESABILITA BOTÕES AOÓS WIN CONDITION
		}
		textField.setForeground(Color.GREEN);
		textField.setText("X Ganhou");
	}
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false); 			//DESABILITA BOTÕES AOÓS WIN CONDITION
		}
		textField.setForeground(Color.GREEN);
		textField.setText("O Ganhou");	
	}
}
