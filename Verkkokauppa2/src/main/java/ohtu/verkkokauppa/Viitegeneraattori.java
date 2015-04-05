package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;
@Component
public class Viitegeneraattori implements ViitegeneraattoriI {

    private static Viitegeneraattori instanssi;

    public Viitegeneraattori() {
        seuraava = 1;
    }

    private int seuraava;

    @Override
    public int uusi() {
        return seuraava++;
    }
}
