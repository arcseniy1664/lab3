package bsu.rfe.java.group6.lab3.Serba.var6A;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	public GornerTableModel(Double from, Double to, Double step,
			Double[] coefficients) {
		this.from = from;
		this.to = to;
		this.step = step;
		this.coefficients = coefficients;
	}
	public Double getFrom() {
		return from;
	}
	public Double getTo() {
		return to;
	}
	public Double getStep() {
		return step;
	}
	public int getColumnCount() {
		// В данной модели два столбца
		return 3;
	}
	public int getRowCount() {
		// Вычислить количество точек между началом и концом отрезка
		// исходя из шага табулирования
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}
	public Object getValueAt(int row, int col) {
		// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
		double x = from + step*row;
		double result;
		
		if (col==0) {
			return x;
		} else if(col==1){
			result = coefficients[0];
			for(int i=1;i< coefficients.length;i++) {
				result=result*x+coefficients[i];
			}
			return result;
		} else {
			result = coefficients[0];
			for(int i=1;i< coefficients.length;i++) {
				result=result*x+coefficients[i];
			}
			return (Math.ceil(result)-result<0.1 ) ;
		}
	}
		public String getColumnName(int col) {
			switch (col) {
			case 0:
				return "Значение X";
			case 1:
				return "Значение многочлена";
			case 2:
				return "БЛИЗКО К ЦЕЛОМУ?";
				default:
					return "";
			}
	}
	
	
	public Class<?> getColumnClass(int col) {

		if(col==2) {
			return Boolean.class;
		}
		return Double.class;
	}
}