export interface Comentario {
  id: number;
  autor: string;
  comentario: string;
  data: string;
  pontoTuristicoId: number;
}

export interface NovoComentario {
  autor: string;
  comentario: string;
  data: string;
  pontoTuristicoId: number;
}
