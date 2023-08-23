package hotel.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import hotel.model.entities.Reserva;
import hotel.model.exeptions.excecao;

public class Programa {
  public static void main(String[] args) throws excecao {
    try {
      Scanner sc = new Scanner(System.in);
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      System.out.print("Número do quarto: ");
      int quarto = sc.nextInt();
      System.out.print("Data de check-in (dd/mm/aaaa): ");
      Date checkIn = sdf.parse(sc.next());
      System.out.print("Data de check-out (dd/mm/aaaa): ");
      Date checkOut = sdf.parse(sc.next());

      Reserva reserva = new Reserva(quarto, checkIn, checkOut);
      System.out.println(reserva);

      System.out.println();

      System.out.println("Atualização de datas da reserva: ");
      System.out.print("Data de check-in (dd/mm/aaaa): ");
      checkIn = sdf.parse(sc.next());
      System.out.print("Data de check-out (dd/mm/aaaa): ");
      checkOut = sdf.parse(sc.next());

      reserva.atualizarData(checkIn, checkOut);
      System.out.println(reserva);

      sc.close();

    } catch (ParseException e) {
      System.out.println("Formato da data inválido.");
    } catch (excecao e) {
      System.out.println("Erro ao efetuar a reserva: " + e.getMessage());
    } catch (RuntimeException e) {
      System.out.println("Erro inesperado: " + e.getMessage());
    }
  }
}