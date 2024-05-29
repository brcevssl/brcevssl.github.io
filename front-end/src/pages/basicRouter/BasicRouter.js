import { BrowserRouter } from 'react-router-dom';

const basicRouter = ({ children }) => {
  return <BrowserRouter>{children}</BrowserRouter>;
};

export default basicRouter;