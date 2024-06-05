package T20.MemoryGame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameServer {
	
		public static void saveGame(String fileName, String gameData) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
				writer.write(gameData);
				System.out.println("Partida guardada con exito en: " + new File(fileName).getAbsolutePath());
			} catch (IOException e) {
				System.err.println("ERROR al guardar la partida: " + e.getMessage());
			}
		}

	}
