package aplicacao;
import codigos.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Uso para testar todas as classes implementadas no pacote codigos, com a criação de uma agenda onde se pode criar
 * metas, lembretes e eventos e gerar alguns relatórios de acordo com o desejo do usuario
 * <p>
 * 
 * 
 * @author Diogenes F.
 *
 */

public class Uso {

	public static void main(String[] args) {
		Agenda itens_da_agenda = new Agenda();
		int escolha = 1, dia_in, mes_in, ano_in, dia_fim, mes_fim, ano_fim, hr_in,min_in,seg_in, hr_fim,min_fim,seg_fim;
		int prioridade, min_antecedencia, ver = 0;
		String registro, descricao, local;
		Data data_inicio, data_fim;
		Horario horario_inicio,horario_fim;
		Periodo periodo = null;
		Evento evento = null;
		Meta meta = null;
		Lembrete lembrete = null;
		
		System.out.println("-------------AGENDA-------------");
		while (escolha != 0) {
			System.out.println("1 - Adicionar um evento\n2 - Adicionar uma meta\n3 - Adicionar um lembrete\n"
					+ "4 - Exibir todos os itens da agenda\n5 - Exibir todos os itens em um intervalo de data\n"
					+ "6 - Exibir as metas em ordem de prioridade\n7 - Exibir lembretes por minutos de antecedencia\n"
					+ "8 - Exibir eventos por ordem de local\n9 - Salvar agenda em disco\n10 - Recuperar agenda do disco\n"
					+ "0 - Sair: ");
			escolha = new Scanner(System.in).nextInt();
			if (escolha == 1) {
				System.out.println("Entre com o nome do registro do evento: ");
				registro = new Scanner(System.in).nextLine();
				System.out.println("Entre com a descricao do evento: ");
				descricao = new Scanner(System.in).nextLine();
				System.out.println("Entre com o local do evento: ");
				local = new Scanner(System.in).nextLine();
				while (true) {
					ver = 0;
					while (true) {
						System.out.println("Entre com a data de inicio do evento");
						System.out.println("Dia: ");
						dia_in = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_in = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_in = new Scanner(System.in).nextInt();
						try {
							data_inicio = new Data(dia_in,mes_in,ano_in);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					while (true) {
						System.out.println("Entre com a data de termino do evento");
						System.out.println("Dia: ");
						dia_fim = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_fim = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_fim = new Scanner(System.in).nextInt();
						try {
							data_fim = new Data(dia_fim,mes_fim,ano_fim);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					if (Data.compareTo(data_inicio, data_fim) == 1) {
						System.out.println("A data inicial deve vim antes da final!!");
					}
					else if (Data.compareTo(data_inicio, data_fim) == 0) {
						ver++;
						break;
					}
					else {
						break;
					}
				}
				while (true) {
					while (true) {
						System.out.println("Entre com o horario de inicio do evento");
						System.out.println("Horas: ");
						hr_in = new Scanner(System.in).nextInt();
						System.out.println("Minutos: ");
						min_in = new Scanner(System.in).nextInt();
						System.out.println("Segundos: ");
						seg_in = new Scanner(System.in).nextInt();
						try {
							horario_inicio = new Horario(hr_in,min_in,seg_in);
							break;
						} catch (Exception e) {
							System.out.println("Horario invalido!!");
						}
					}
					while (true) {
						System.out.println("Entre com o horario de termino do evento");
						System.out.println("Horas: ");
						hr_fim = new Scanner(System.in).nextInt();
						System.out.println("Minutos: ");
						min_fim = new Scanner(System.in).nextInt();
						System.out.println("Segundos: ");
						seg_fim = new Scanner(System.in).nextInt();
						try {
							horario_fim = new Horario(hr_fim,min_fim,seg_fim);
							break;
						} catch (Exception e) {
							System.out.println("Horario invalido!!");
						}
					}
					if (ver == 1 && Horario.compareTo(horario_inicio, horario_fim) == 1) {
						System.out.println("O horario inicial deve vim antes do final!!");
					}
					else {
						break;
					}
				}
				
				periodo = new Periodo(data_inicio,data_fim,horario_inicio,horario_fim);
				evento = new Evento(registro, descricao, periodo, local);
				itens_da_agenda.insereItem(evento);
				System.out.println("Evento adicionado com sucesso!!\n");
			}
			else if (escolha == 2) {
				System.out.println("Entre com o nome do registro da meta: ");
				registro = new Scanner(System.in).nextLine();
				System.out.println("Entre com a descricao da meta: ");
				descricao = new Scanner(System.in).nextLine();
				while (true) {
					ver = 0;
					while (true) {
						System.out.println("Entre com a data de inicio da meta:");
						System.out.println("Dia: ");
						dia_in = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_in = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_in = new Scanner(System.in).nextInt();
						try {
							data_inicio = new Data(dia_in,mes_in,ano_in);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					while (true) {
						System.out.println("Entre com a data de termino da meta:");
						System.out.println("Dia: ");
						dia_fim = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_fim = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_fim = new Scanner(System.in).nextInt();
						try {
							data_fim = new Data(dia_fim,mes_fim,ano_fim);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					if (Data.compareTo(data_inicio, data_fim) == 1) {
						System.out.println("A data inicial deve vim antes da final!!");
					}
					else if (Data.compareTo(data_inicio, data_fim) == 0) {
						ver++;
						break;
					}
					else {
						break;
					}
				}
				while (true) {
					while (true) {
						System.out.println("Entre com o horario de inicio da meta:");
						System.out.println("Horas: ");
						hr_in = new Scanner(System.in).nextInt();
						System.out.println("Minutos: ");
						min_in = new Scanner(System.in).nextInt();
						System.out.println("Segundos: ");
						seg_in = new Scanner(System.in).nextInt();
						try {
							horario_inicio = new Horario(hr_in,min_in,seg_in);
							break;
						} catch (Exception e) {
							System.out.println("Horario invalido!!");
						}
					}
					while (true) {
						System.out.println("Entre com o horario de termino da meta:");
						System.out.println("Horas: ");
						hr_fim = new Scanner(System.in).nextInt();
						System.out.println("Minutos: ");
						min_fim = new Scanner(System.in).nextInt();
						System.out.println("Segundos: ");
						seg_fim = new Scanner(System.in).nextInt();
						try {
							horario_fim = new Horario(hr_fim,min_fim,seg_fim);
							break;
						} catch (Exception e) {
							System.out.println("Horario invalido!!");
						}
					}
					if (ver == 1 && Horario.compareTo(horario_inicio, horario_fim) == 1) {
						System.out.println("O horario inicial deve vim antes do final!!");
					}
					else {
						break;
					}
				}
				
				periodo = new Periodo(data_inicio,data_fim,horario_inicio,horario_fim);
				while (true) {
					System.out.println("Entre com a prioridade da meta: ");
					prioridade = new Scanner(System.in).nextInt();
					try {
						meta = new Meta(registro, descricao, periodo, prioridade);
						break;
					} catch (Exception e) {
						System.out.println("Valor invalido!!");
					}
				}
				itens_da_agenda.insereItem(meta);
				System.out.println("Meta adicionada com sucesso!!\n");
			}
			else if (escolha == 3) {
				ver = 0;
				System.out.println("Entre com o nome do registro do lembrete: ");
				registro = new Scanner(System.in).nextLine();
				System.out.println("Entre com a descricao do lembrete: ");
				descricao = new Scanner(System.in).nextLine();
				
				while (true) {
					while (true) {
						System.out.println("Entre com a data de inicio do lembrete:");
						System.out.println("Dia: ");
						dia_in = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_in = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_in = new Scanner(System.in).nextInt();
						try {
							data_inicio = new Data(dia_in,mes_in,ano_in);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					while (true) {
						System.out.println("Entre com a data de termino do lembrete:");
						System.out.println("Dia: ");
						dia_fim = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_fim = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_fim = new Scanner(System.in).nextInt();
						try {
							data_fim = new Data(dia_fim,mes_fim,ano_fim);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					if (Data.compareTo(data_inicio, data_fim) == 1) {
						System.out.println("A data inicial deve vim antes da final!!");
					}
					else if (Data.compareTo(data_inicio, data_fim) == 0) {
						ver++;
						break;
					}
					else {
						break;
					}
				}
				
				while (true) {
					while (true) {
						System.out.println("Entre com o horario de inicio do lembrete:");
						System.out.println("Horas: ");
						hr_in = new Scanner(System.in).nextInt();
						System.out.println("Minutos: ");
						min_in = new Scanner(System.in).nextInt();
						System.out.println("Segundos: ");
						seg_in = new Scanner(System.in).nextInt();
						try {
							horario_inicio = new Horario(hr_in,min_in,seg_in);
							break;
						} catch (Exception e) {
							System.out.println("Horario invalido!!");
						}
					}
					while (true) {
						System.out.println("Entre com o horario de termino do lembrete:");
						System.out.println("Horas: ");
						hr_fim = new Scanner(System.in).nextInt();
						System.out.println("Minutos: ");
						min_fim = new Scanner(System.in).nextInt();
						System.out.println("Segundos: ");
						seg_fim = new Scanner(System.in).nextInt();
						try {
							horario_fim = new Horario(hr_fim,min_fim,seg_fim);
							break;
						} catch (Exception e) {
							System.out.println("Horario invalido!!");
						}
					}
					if (Data.compareTo(data_inicio, data_fim) == 1) {
						System.out.println("A data inicial deve vim antes da final!!");
					}
					if (ver == 1 && Horario.compareTo(horario_inicio, horario_fim) == 1) {
						System.out.println("O horario inicial deve vim antes do final!!");
					}
					else {
						break;
					}
				}
				periodo = new Periodo(data_inicio,data_fim,horario_inicio,horario_fim);
				while (true) {
					System.out.println("Entre com a quantidade de minutos de antecedencia para o alerta: ");
					min_antecedencia = new Scanner(System.in).nextInt();
					try {
						lembrete = new Lembrete(registro, descricao, periodo, min_antecedencia);
						break;
					} catch (Exception e) {
						System.out.println("Valor invalido!!");
					}
				}
				itens_da_agenda.insereItem(lembrete);
				System.out.println("Lembrete adicionado com sucesso!!\n");
			}
			else if (escolha == 4) {
				System.out.println(itens_da_agenda.getItensDaAgenda());
			}
			else if (escolha == 5) {
				while (true) {
					while (true) {
						System.out.println("Entre com a data inicial do intervalo: ");
						System.out.println("Dia: ");
						dia_in = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_in = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_in = new Scanner(System.in).nextInt();
						try {
							data_inicio = new Data(dia_in,mes_in,ano_in);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					while (true) {
						System.out.println("Entre com a data final do intervalo: ");
						System.out.println("Dia: ");
						dia_fim = new Scanner(System.in).nextInt();
						System.out.println("Mes: ");
						mes_fim = new Scanner(System.in).nextInt();
						System.out.println("Ano: ");
						ano_fim = new Scanner(System.in).nextInt();
						try {
							data_fim = new Data(dia_fim,mes_fim,ano_fim);
							break;
						} catch (Exception e) {
							System.out.println("Data invalida!!");
						}
					}
					if (Data.compareTo(data_inicio, data_fim) == 1) {
						System.out.println("A data inicial deve vim antes da final!!");
					}
					else {
						break;
					}
				}
				System.out.println(itens_da_agenda.informaItensNoIntervaloDeData(data_inicio, data_fim));
			}
			else if (escolha == 6) {
				System.out.println(itens_da_agenda.informaMetasPorPrioridade().toString());
			}
			else if (escolha == 7) {
				System.out.println(itens_da_agenda.informaLembretesPorMinDeAntecedencia().toString());
			}
			else if (escolha == 8) {
				System.out.println(itens_da_agenda.informaEventosPorLocal());
			}
			else if (escolha == 9) {
				try {
					BufferedWriter arqSaida;
					arqSaida = new BufferedWriter(new FileWriter("arquivo_de_saida.txt"));  
					arqSaida.write(itens_da_agenda.toString()+"\r\n");
					arqSaida.close();
					System.out.println("Gravado com sucesso!!\n");
					
				} catch(FileNotFoundException e) {
					System.out.println("Arquivo não encontrado");
				}
				catch(IOException e) {
					System.out.println("Problemas na leitura ou gravação do arquivo");
				}
				catch (Exception e) {
					e.getMessage();
				}
			}
			else if (escolha == 10) {
				try {
					BufferedReader arqEnt;
					arqEnt = new BufferedReader(new FileReader("C:\\Users\\dioge\\eclipse-workspace\\PROVA_2\\arquivo_de_saida.txt"));
					int i;    
			          while((i=arqEnt.read())!=-1) {
			        	  
			        	  System.out.print((char)i);
			          }
			          arqEnt.close();
					
				} catch(FileNotFoundException e) {
					System.out.println("Arquivo não encontrado");
				}
				catch(IOException e) {
					System.out.println("Problemas na leitura ou gravação do arquivo");
				}
				catch (Exception e) {
					e.getMessage();
				}
			}
			else if (escolha == 0) {
				break;
			}
			else {
				System.out.println("Opcao invalida!!\n");
			}
		}
	}
}
