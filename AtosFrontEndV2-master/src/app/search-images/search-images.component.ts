import { Component, OnInit } from '@angular/core';
import { FlickrService } from '../services/flickr.service';


@Component({
  selector: 'app-search-images',
  templateUrl: './search-images.component.html',
  styleUrls: ['./search-images.component.css']
})

export class SearchImagesComponent implements OnInit {
  images = [];
  keyword: string;

  constructor(private flickrService: FlickrService) { }

  ngOnInit() {
  }
//Metodo de Buscar
  search(event: any) {
    this.keyword = event.target.value.toLowerCase();
    if (this.keyword && this.keyword.length > 0) {
      this.flickrService.search_keyword(this.keyword)
      .toPromise()
      .then(res => {
        this.images = res;
      });
    }
  }
  //Metodo de Buscar Componente
  searchComponent(event: any) {
    
    if (this.keyword && this.keyword.length > 0) {
      this.flickrService.search_keyword(this.keyword)
      .toPromise()
      .then(res => {
        this.images = res;
      });
    }
  }
  //Metodo de onScroll
  onScroll() {
    if (this.keyword && this.keyword.length > 0) {
      this.flickrService.search_keyword(this.keyword)
      .toPromise()
      .then(res => {
        this.images = this.images.concat(res);
      });
    }
  }
//Metodos de Botones de Categorias
  Daewoo(){
    this.keyword = 'Daewoo'.toLowerCase();
    }
  BMW(){
  this.keyword = 'BMW'.toLowerCase();
   }
  Mercedes(){
  this.keyword = 'Mercedes'.toLowerCase();
    }
}
