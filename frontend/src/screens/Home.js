import React, { useEffect, useState, useCallback } from 'react';
import axios from 'axios';

const Home = () => {
  const [location, setLocation] = useState('');
  const [articles, setArticles] = useState([]);
  const [loading, setLoading] = useState(false);

  const fetchNews = useCallback(async () => {
    setLoading(true);
    try {
      const response = await axios.get(`https://newsapi.org/v2/everything?q=${location}&apiKey=YOUR_API_KEY`);
      setArticles(response.data.articles);
    } catch (error) {
      console.error('Error fetching news:', error);
    } finally {
      setLoading(false);
    }
  }, [location]);

  useEffect(() => {
    if (location) {
      fetchNews();
    }
  }, [location, fetchNews]);

  return (
    <div>
      <h1>Local News</h1>
      <input
        type="text"
        value={location}
        onChange={(e) => setLocation(e.target.value)}
        placeholder="Enter location"
      />
      <button onClick={fetchNews}>Fetch News</button>
      
      {loading && <p>Loading...</p>}
      
      <div>
        {articles.map((article, index) => (
          <div key={index}>
            <h2>{article.title}</h2>
            <p>{article.description}</p>
            <a href={article.url} target="_blank" rel="noopener noreferrer">Read more</a>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Home;
