# E-Commerce AI Agent API

## Proje Hakkında

Bu proje, Trendyol, Hepsiburada, Amazon gibi platformlarda mağazaları olan dükkan sahiplerinin müşterileriyle etkileşimde bulunmasını kolaylaştıran bir yapay zeka destekli API çözümüdür. Müşteriler, günlük konuşma diliyle örneğin;

> "Adidas Yeezy ayakkabısından kaç tane var?",  
> "Beyaz rengi mevcut mu?",  
> "Fiyatı kaç TL?"  

gibi sorularını yazılı olarak yapay zekaya iletebilirler ve sistem, stok durumu, renk seçenekleri ve fiyat bilgisi gibi verileri anlayıp yanıtlar.

Sistem, büyük dil modelleri (LLM) ve Retrieval-Augmented Generation (RAG) teknolojileri kullanılarak geliştirilmiştir. Proje, Docker konteynerleri içerisinde çalışacak şekilde tasarlanmıştır.

---

## Temel Özellikler

- Günlük dilde yazılan soruları anlama ve cevaplama  
- Trendyol, Hepsiburada, Amazon gibi e-ticaret platformları için entegre mağaza yönetimi  
- LLM + RAG tabanlı bilgi erişimi ve cevap oluşturma  
- Docker destekli kolay dağıtım ve yönetim  

---

## Teknolojiler

- Java Spring Boot (Backend API)  
- Docker (Containerization)  
- Large Language Models (LLM) ve Retrieval-Augmented Generation (RAG)  
- RESTful API  

---

## Başlarken

### Gereksinimler

- Docker ve Docker Compose  
- Java 17
- Maven 

### Projeyi Çalıştırma

1. Repository’i klonlayın:  
```bash
git clone https://github.com/hselimtuna/e_commerce-ai-agent-api.git
```
2. Proje dizinine girin:
```bash
cd e_commerce-ai-agent-api
```
3. Docker ile servisleri başlatın(Eklenecek):
```bash
docker-compose up --build
```
