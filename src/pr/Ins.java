package pr;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class Ins extends JFrame implements ActionListener{

	private JTextField  tfNumbers , tfRange;
	private JCheckBox cbInsertion , cbQuick , cbMerge , cbCounting;
	private List<InputArray> inputArrays;
	private List<OutputItem> outputItems;
	private JScrollPane jScrollPane;
	private JTextArea tfTitle;
	private JButton btGenerateRand ,btTakeArr1 , btSelectSort , btShowGraph;
	private int[] iA;
	Ins()
	{
		//initialize array of input arrays
		inputArrays = new ArrayList<>();
		outputItems = new ArrayList<>();
		
		//setting parameters about frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1000 , 1000);
		setLayout(null);
		
		//defining components
		tfTitle = new JTextArea();
		jScrollPane = new JScrollPane(tfTitle);
		btTakeArr1 = new JButton("Take Input");
		tfNumbers = new JTextField();
		tfRange = new JTextField();
		btGenerateRand = new JButton("Generate");
		cbInsertion = new JCheckBox("Insertion Sort");
		cbQuick = new JCheckBox("Quick Sort");
		cbMerge = new JCheckBox("Merge Sort");
		cbCounting = new JCheckBox("Counting Sort");
		btSelectSort = new JButton("Sort");
		btShowGraph = new JButton("Plot Graph");

		// adding components to frame
		add(jScrollPane);
		add(btTakeArr1);
		add(tfNumbers);
		add(tfRange);
		add(btGenerateRand);
		add(cbInsertion);
		add(cbQuick);
		add(cbMerge);
		add(cbCounting);
		add(btSelectSort);
		add(btShowGraph);

		//set Coordinates and Size
		JLabel enterArrayLabel = new JLabel("Please Enter Array Here");
		add(enterArrayLabel);
		enterArrayLabel.setBounds(20,10,180,60);
		jScrollPane.setBounds(220,10,180,60);
		btTakeArr1.setBounds(420,20,100,40);
		JLabel enterInputsLabel = new JLabel("How many Numbers You Want Generate");
		add(enterInputsLabel);
		enterInputsLabel.setBounds(20,80,250,60);
		tfNumbers.setBounds(290,80,80,60);
		JLabel enterRangeLabel = new JLabel("Range of Numbers You Want Generate");
		add(enterRangeLabel);
		enterRangeLabel.setBounds(390,80,250,60);
		tfRange.setBounds(660,80,80,60);
		btGenerateRand.setBounds(760,80,100,40);
		cbInsertion.setBounds(20,150,120,15);
		cbQuick.setBounds(20,175,120,15);
		cbMerge.setBounds(20,200,120,15);
		cbCounting.setBounds(20,225,120,15);
		btSelectSort.setBounds(170, 250, 100, 40);
		btShowGraph.setBounds(200,300,100,40);

		//Set Description
		tfTitle.setToolTipText("Enter the Array here.") ;
		tfNumbers.setToolTipText("Enter the number of elements in Array");
		tfRange.setToolTipText("Enter the range of elements in Array");
		btTakeArr1.setToolTipText("Submit The Array.") ;
		btShowGraph.setToolTipText("Plot The OutPut Graph minimun input is 2");

		//set Colors
		tfTitle.setBackground(Color.CYAN);
		tfNumbers.setBackground(Color.CYAN);
		tfRange.setBackground(Color.CYAN);
		btTakeArr1.setBackground(Color.BLUE);
		btGenerateRand.setBackground(Color.BLUE);
		btSelectSort.setBackground(Color.BLUE);
		btShowGraph.setBackground(Color.MAGENTA);

		//setActionListeners
		btTakeArr1.addActionListener(this);
		btGenerateRand.addActionListener(this);
		btSelectSort.addActionListener(this);
		btShowGraph.addActionListener(this);

		//Wrap Text of TextArea
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tfTitle.setLineWrap(true);
		tfTitle.setWrapStyleWord(true);
		
		//set all checkBoxes Invisible Initially
		cbInsertion.setVisible(false);
		cbQuick.setVisible(false);
		cbMerge.setVisible(false);
		cbCounting.setVisible(false);
		btSelectSort.setVisible(false);
		
	}
	
	public static void main(String args[]) {
	   new Ins();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btTakeArr1) {
		String receivedArrayString = tfTitle.getText().toString();
		int length = receivedArrayString.length();
		if(length > 0)
		{
			visibleChoosenOption();
			String temp[] = receivedArrayString.split(" ");
			int iArray[] = new int[temp.length];
			for(int i = 0 ; i < iArray.length ; i++)
			{
				iArray[i] = Integer.parseInt(temp[i]);
			}
			InputArray inputArray =new InputArray(iArray);
			inputArrays.add(inputArray);
		}
		else
		{
			//empty string

			JOptionPane.showMessageDialog( null, "Array is Empty", "Error", JOptionPane.ERROR_MESSAGE);
		}
		}
		else if(e.getSource() == btGenerateRand)
		{
			tfTitle.setText("");

			Runnable ru = new Runnable()
			{
					@Override
					public void run() {
						// TODO Auto-generated method stub
							Random r = new Random();
							iA = new int[Integer.parseInt(tfNumbers.getText().toString())];
							for(int i = 0 ; i < iA.length ; i++)
							{
								iA[i] = r.nextInt(Integer.parseInt(tfRange.getText().toString()));
								tfTitle.setText(tfTitle.getText().toString() + iA[i] + " "); 
							}
						}
				
					};
			Thread t = new Thread(ru);
			t.setPriority(Thread.MAX_PRIORITY);
			t.start();
		}
		else if(e.getSource() == btSelectSort)
		{
			if(cbInsertion.isSelected() )
			{
				int temp[] = new int[inputArrays.get(inputArrays.size() - 1).getArr().length];
				if(iA.length > 0)
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = iA[i];
				}
				else
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = inputArrays.get(inputArrays.size() - 1).getArr()[i];
				}
				long initT = System.currentTimeMillis();
				InsertionSort.insertionSort(temp, temp.length);
				long finalT = System.currentTimeMillis(); 
				OutputItem item = new OutputItem(inputArrays.get(inputArrays.size()-1),cbInsertion.getText().toString(), finalT-initT , temp);
				outputItems.add(item);
				visibleMainOption();
				//printList();
			}
			if(cbQuick.isSelected())
			{
				int temp[] = new int[inputArrays.get(inputArrays.size() - 1).getArr().length];
				if(iA.length > 0)
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = iA[i];
				}
				else
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = inputArrays.get(inputArrays.size() - 1).getArr()[i];
				}
				long initT = System.currentTimeMillis();
				QuickSort.quickSort(temp, 0, temp.length - 1);
				long finalT = System.currentTimeMillis(); 
				OutputItem item = new OutputItem(inputArrays.get(inputArrays.size()-1),cbQuick.getText().toString(), finalT-initT , temp);
				outputItems.add(item);
				visibleMainOption();
				//printList();
			}
			if(cbMerge.isSelected())
			{
				int temp[] = new int[inputArrays.get(inputArrays.size() - 1).getArr().length];
				if(iA.length > 0)
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = iA[i];
				}
				else
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = inputArrays.get(inputArrays.size() - 1).getArr()[i];
				}
				long initT = System.currentTimeMillis();
				MergeSort.mergesort(temp, 0 , temp.length - 1);
				long finalT = System.currentTimeMillis();
				OutputItem item = new OutputItem(inputArrays.get(inputArrays.size()-1),cbMerge.getText().toString(), finalT-initT , temp);
				outputItems.add(item);
				visibleMainOption();
				//printList();
			}
			if(cbCounting.isSelected())
			{
				int temp[] = new int[inputArrays.get(inputArrays.size() - 1).getArr().length];
				if(iA.length > 0)
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = iA[i];
				}
				else
				{
					for(int i = 0 ; i < temp.length ; i++)
						temp[i] = inputArrays.get(inputArrays.size() - 1).getArr()[i];
				}
				int max = Arrays.stream(temp).max().getAsInt();
				int oA[] = new int[temp.length];
				long initT = System.currentTimeMillis();
				CountingSort.countingSort(temp, oA , max);
				long finalT = System.currentTimeMillis();
				OutputItem item = new OutputItem(inputArrays.get(inputArrays.size()-1),cbCounting.getText().toString(), finalT-initT , oA);
				outputItems.add(item);
				visibleMainOption();
				//printList();
			}
			if(!(cbInsertion.isSelected() || cbQuick.isSelected() || cbMerge.isSelected() || cbCounting.isSelected()))
			JOptionPane.showMessageDialog(null, "Please Select Any Sorting Algo First!","!!!Select!!!",JOptionPane.INFORMATION_MESSAGE);
			
			
		}
		else if(e.getSource() == btShowGraph)
		{
			if(outputItems.size() > 1)
			{
				List<Integer> result = checkForEveryAlgo();
				if(result !=  null)
				{
					XYSeriesCollection dataset = new XYSeriesCollection();
					for(int i :  result)
					{
						switch (i)
						{
							case 0 :
								XYSeries seriesIns = new XYSeries("Insertion Sort");
                                 for(OutputItem item : outputItems)
								 {
									 if(item.getSortType().equals(cbInsertion.getText().toString()))
									 {
										 seriesIns.add(item.getInputArray().getArr().length,item.getTime());
									 }
								 }
								 seriesIns.setDescription("Insertion Sort");
                                 dataset.addSeries(seriesIns);
								//insertion sort graph
								break;
							case 1 :
								//Quick sort graph
								XYSeries seriesQuick = new XYSeries("Quick Sort");
								for(OutputItem item : outputItems)
								{
									if(item.getSortType().equals(cbQuick.getText().toString()))
									{
										seriesQuick.add(item.getInputArray().getArr().length,item.getTime());
									}
								}
								seriesQuick.setDescription("Quick Sort");
								dataset.addSeries(seriesQuick);
								break;
							case 2 :
								//Merge Sort graph
								XYSeries seriesMerge = new XYSeries("Merge Sort");
								for(OutputItem item : outputItems)
								{
									if(item.getSortType().equals(cbMerge.getText().toString()))
									{
										seriesMerge.add(item.getInputArray().getArr().length,item.getTime());
									}
								}
								seriesMerge.setDescription("Merge Sort");
								dataset.addSeries(seriesMerge);
								break;
							case 3 :
								//Counting Sort graph
								XYSeries seriesCounting = new XYSeries("Counting Sort");
								for(OutputItem item : outputItems)
								{
									if(item.getSortType().equals(cbCounting.getText().toString()))
									{
										seriesCounting.add(item.getInputArray().getArr().length,item.getTime());
									}
								}
								seriesCounting.setDescription("Counting Sort");
								dataset.addSeries(seriesCounting);
								break;
						}
					}
					JPanel panel = createChartPanel(dataset,"Time Complexity of Alogs","No. of Inputs","Time Taken (in Milis)");
					this.add(panel);
					panel.setBounds(150,350,600,250);

				}
				else {
					JOptionPane.showMessageDialog(null, "Please Take Minimum 2 Input For Same Algorithm", "!!!Attention!!!", JOptionPane.ERROR_MESSAGE);
				}
				btShowGraph.setEnabled(true);
			}
			else
				JOptionPane.showMessageDialog(null, "Please Take Minimum 2 Input For Any Same Algorithm", "!!!Attention!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private List<Integer> checkForEveryAlgo() {
		btShowGraph.setEnabled(false);
		List<Integer> result = new ArrayList<>();
		int count[] = { 0 , 0 , 0 , 0};
		for(OutputItem item : outputItems)
		{
			switch (item.getSortType())
			{
				case "Insertion Sort" :
					count[0]++;
					break;
				case "Quick Sort":
					count[1]++;
					break;
				case "Merge Sort":
					count[2]++;
					break;
				case "Counting Sort":
					count[3]++;
					break;
			}
		}
		for(int i = 0 ; i < count.length ; i++)
		{
			if(count[i] >= 2)
			{
				if(!result.contains(i))
				result.add(i);
			}
		}
		if(result.size() > 0)
			return result;
		return null;
	}

//	private void printList() {
//		// TODO Auto-generated method stub
//		    for(OutputItem item : outputItems) {
//					System.out.println(item.getSortType() + " " + item.getTime() + " at " + item.getInputArray().getArr().length + " inputs");
//					System.out.print("Input Array: ");
//					for (int i : item.getInputArray().getArr())
//						System.out.print(i + " ");
//					System.out.print("\nSorted Array: ");
//					for (int i : item.getSortedArray())
//						System.out.print(i + " ");
//					System.out.println();
//		    }
//	}

	private void visibleChoosenOption() {
		// TODO Auto-generated method stub
		tfTitle.setEditable(false);
		btTakeArr1.setEnabled(false);
		tfNumbers.setEditable(false);
		tfRange.setEditable(false);
		btGenerateRand.setEnabled(false);
		cbInsertion.setVisible(true);
		cbQuick.setVisible(true);
		cbMerge.setVisible(true);
		cbCounting.setVisible(true);
		btSelectSort.setVisible(true);
	}
	
	private void visibleMainOption() {
		// TODO Auto-generated method stub
		tfTitle.setEditable(true);
		btTakeArr1.setEnabled(true);
		tfNumbers.setEditable(true);
		tfRange.setEditable(true);
		tfTitle.setText("");
		tfNumbers.setText("");
		tfRange.setText("");
		btGenerateRand.setEnabled(true);
		cbInsertion.setVisible(false);
		cbQuick.setVisible(false);
		cbMerge.setVisible(false);
		cbCounting.setVisible(false);
		btSelectSort.setVisible(false);
	}

	//creating JPanel
	private JPanel createChartPanel(XYDataset dataset , String chartTitle , String xAxisLabel , String yAxisLabel ) {
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,xAxisLabel,yAxisLabel,dataset, PlotOrientation.VERTICAL,true,true,false);
		return new ChartPanel(chart);
	}
}
