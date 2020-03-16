package org.wcci.apimastery;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Album {

        private String name;
        @Id
        @GeneratedValue
        private Long id;
        @ManyToOne
        private Artist artist;
        @OneToMany (mappedBy = "album")
        private Collection<Song>songs;

        protected Album(){
        }
        public Album(String name, Artist artist){
            this.name = name;
            this.artist = artist;
        }

        public String getName() {
                return name;
        }

        public Long getId() {
                return id;
        }

        public Artist getArtist() {
                return artist;
        }

        public Collection<Song> getSongs() {
                return songs;
        }
}