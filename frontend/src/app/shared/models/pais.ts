export interface Pais {
  id: number,
  nome: string,
  sigla: string,
  continente: string,
  ddi: number
}

//ddi = codigo Ddi
export interface NovoPais {
  nome: string,
  sigla: string,
  continente: string,
  ddi: number
}
