package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.assertj.core.util.Arrays;


@SpringBootTest
public class StatistiqueTests {

    @Autowired
    StatistiqueImpl statistiqueImpl;

    @Test
    void TestStatistique(){
        Voiture v1 = mock(Voiture.class);
        Voiture v2 = mock(Voiture.class);

        when(v1.getPrix()).thenReturn(10000);
        when(v2.getPrix()).thenReturn(20000);

        statistiqueImpl.ajouter(v2);
        statistiqueImpl.ajouter(v1);
        
        assertTrue(statistiqueImpl.voitures.contains(v1));
        assertTrue(statistiqueImpl.voitures.contains(v2));

        Echantillon resEchantillon = statistiqueImpl.prixMoyen();

        assertEquals(resEchantillon.getNombreDeVoitures(), 2);

        assertEquals(resEchantillon.getPrixMoyen(), 15000);
        
        verify(v1,times(1)).getPrix();
        verify(v2,times(1)).getPrix();

        
    };

}
