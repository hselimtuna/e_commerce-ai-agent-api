E-Commerce AI Agent API 🤖🛒

📋 Proje Açıklaması

Bu proje, Trendyol, Hepsiburada, Amazon gibi e-ticaret platformlarındaki mağazalar için AI destekli müşteri hizmetleri ve otomatik iş süreçleri sağlayan kapsamlı bir mikroservis sistemidir.

🎯 Temel Özellikler

* AI Destekli Müşteri Sorgulama: "Reebok Nano 7 ayakkabı var mı?", "Adidas Yeezy 42 numara siyah ayakkabı ne kadar?" gibi doğal dil sorguları
* RAG (Retrieval-Augmented Generation): LLM + veritabanı entegrasyonu ile akıllı ürün önerileri
* Otomatik E-Fatura Entegrasyonu: Micro, Logo, Paraşüt gibi sistemlerle otomatik fatura işleme
* Akıllı İade Yönetimi: Otomatik iade süreç yönetimi
* Multi-Tenant Mimari: Tek veritabanında birden fazla mağaza desteği

🏗️ Teknoloji Stack'i

Backend

* Framework: Spring Boot (Java)
* Database: PostgreSQL (Multi-tenant yapı, hassas veriler hashlenmiş)
* Security: Spring Security + Google OAuth 2.0
* ORM: Spring Data JPA

AI & Search

* Search Engine: Elasticsearch (RAG için vector search)
* Monitoring & Analytics: Kibana (log yönetimi ve veri görselleştirme)
* LLM Integration: Yapılandırılabilir LLM provider desteği (OpenAI, Anthropic, Azure OpenAI)

Mikroservis & Mesajlaşma

* Message Queue: RabbitMQ (asenkron mikroservis iletişimi)
* Caching: Redis (performans optimizasyonu)
* API Gateway: Spring Cloud Gateway

DevOps & Deployment

* Containerization: Docker
* Container Orchestration: Docker Compose

🚀 Özellikler

👥 Müşteri Özellikleri

* Doğal dil ile ürün sorgulama
* AI destekli ürün önerileri
* Gerçek zamanlı stok kontrol
* Akıllı fiyat karşılaştırma
* Sipariş durumu takibi

🏪 Mağaza Sahibi Özellikleri

* Otomatik e-fatura oluşturma (Micro, Logo, Paraşüt entegrasyonu)
* Otomatik iade işlem yönetimi
* AI destekli satış analitiği
* Multi-platform envanter senkronizasyonu
* Gerçek zamanlı dashboard

🔧 Teknik Özellikler

* Ölçeklenebilir Mikroservis Mimarisi
* RAG (Retrieval-Augmented Generation) ile akıllı sorgulama
* Multi-tenant güvenli veritabanı yapısı
* Asenkron işlem desteği
* Redis caching ile yüksek performans
* Docker ile kolay deployment

🛠️ Kurulum

Ön Gereksinimler

* Java 17+
* Docker & Docker Compose
* PostgreSQL 13+
* Redis 6+
* Elasticsearch 8+

Kurulum Adımları

Repository'yi klonlayın

```bash
git clone https://github.com/hselimtuna/e_commerce-ai-agent-api.git
cd e_commerce-ai-agent-api
git checkout dev
```