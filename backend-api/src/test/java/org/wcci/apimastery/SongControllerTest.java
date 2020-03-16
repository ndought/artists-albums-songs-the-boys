package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SongControllerTest {

    private SongRepository songRepo;
    private SongController underTest;
    private Song testSong;
    private Artist testArtist;
    private Album testAlbum;

    @BeforeEach
    void setUp(){
        songRepo = mock(SongRepository.class);
        underTest = new SongController(songRepo);
        testArtist = new Artist("Test Artist");
        testAlbum = new Album("Test Album", testArtist);
        testSong = new Song("Test Song", testArtist, testAlbum);
        when(songRepo.findAll()).thenReturn(Collections.singletonList(testSong));
    }

    @Test
    public void retrieveSongsReturnsListOfSongsFromMockRepo(){
        underTest.retrieveSongs();
        verify(songRepo).findAll();
    }

    @Test
    public void retrieveSongsReturnsListOfSongsContainingMockSong(){
        Collection<Song> result = underTest.retrieveSongs();
        assertThat(result).contains(testSong);
    }

    
}
