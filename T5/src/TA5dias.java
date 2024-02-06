
public class TA5dias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			String dia="Lunes";
	
		switch (dia){
			case "Lunes":
				System.out.println("Hoy es "+dia+ " es laborable");
				break;
			case "Martes":
				System.out.println("Hoy es " +dia+ " es laborable");
				break;
			case "Miercoles":
				System.out.println("Hoy es " +dia+ " es laborable");
				break;
			case "Jueves":
				System.out.println("Hoy es " +dia+ " es laborable");
				break;
			case "Viernes":
				System.out.println("Hoy es " +dia+ " es laborable");
			case "Sabado":
				System.out.println("Hoy es " +dia+ " no es laborable");
				break;
			case "Domingo":
				System.out.println("Hoy es " +dia+ " no es laborable");
				break;
			
			default:
				System.out.println("No as introduciodo un dia correcto");
		}
	}

}
