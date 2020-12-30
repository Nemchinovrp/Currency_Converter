export class Valute {
  id: number;
  date: string;
  idValute: string;
  charCode: string;
  name: string;
  value: string;
  nominal: string;


  constructor(id: number, date: string, idValute: string, charCode: string, name: string, value: string, nominal: string) {
    this.id = id;
    this.date = date;
    this.idValute = idValute;
    this.charCode = charCode;
    this.name = name;
    this.value = value;
    this.nominal = nominal;
  }
}
