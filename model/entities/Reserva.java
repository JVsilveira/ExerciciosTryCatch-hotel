package hotel.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import hotel.model.exeptions.excecao;

public class Reserva {
  private Integer quarto;
  private Date checkIn;
  private Date checkOut;

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  public Reserva() {
  }

  public Reserva(Integer quarto, Date checkIn, Date checkOut) throws excecao {
    if (!checkOut.after(checkIn)) {
      throw new excecao("A data de check-out não pode ser anterior a data de check-in");
    }
    this.quarto = quarto;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer getQuarto() {
    return quarto;
  }

  public void setQuarto(Integer quarto) {
    this.quarto = quarto;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public Date getCheckOut() {
    return checkOut;
  }

  public long dias() {
    long dif = checkOut.getTime() - checkIn.getTime();
    return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
  }

  public void atualizarData(Date checkIn, Date checkOut) throws excecao {
    Date now = new Date();
    if (checkIn.before(now) || checkOut.before(now)) {
      throw new excecao("A data de reserva não pode ser antes da data marcada anteriormente.");
    }
    if (!checkOut.after(checkIn)) {
      throw new excecao("A data de check-out não pode ser antes da data de check-in.");
    }
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  @Override
  public String toString() {
    return "Reserva [Quarto: " + quarto + ", ckeckin: " + sdf.format(checkIn) + ", ckeckout: " + sdf.format(checkOut)
        + ", " + dias() + " noites. ]";
  }

}
