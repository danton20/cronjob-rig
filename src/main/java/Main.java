import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    LocalDateTime localNow = LocalDateTime.now();
    ZoneId currentZone = ZoneId.of("America/Sao_Paulo");
    ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
    ZonedDateTime zonedNext5;
    zonedNext5 = zonedNow.withHour(20).withMinute(0).withSecond(0);
    if (zonedNow.compareTo(zonedNext5) > 0)
      zonedNext5 = zonedNext5.plusDays(1);
    Duration duration = Duration.between(zonedNow, zonedNext5);
    long initalDelay = duration.getSeconds();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    System.out.println("Job iniciado");
    scheduler.scheduleAtFixedRate(new MyTask(), initalDelay, 24 * 60 * 60, TimeUnit.SECONDS);
  }
}