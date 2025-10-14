import { Estacoes } from "../enums/estacoes";
import { Comentario } from "./comentario";
import { Pais } from "./pais";

export interface PontoTuristico {
  id: number;
  nome: string;
  resumo: string;
  cidade: string;
  melhorEstacao: Estacoes;
  paisId: Pais['id'];
  paisNome: Pais['nome'];
  comentarios: Comentario[];
  comentariosCount?: number;
}

export interface NovoPontoTuristico {
  nome: string;
  resumo: string;
  cidade: string;
  melhorEstacao: Estacoes;
  paisId: Pais['id'];
}
