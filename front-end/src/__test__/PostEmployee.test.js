import PostEmployee from '../pages/employee/PostEmployee';
import { render, screen } from "@testing-library/react";
import { createMemoryRouter, RouterProvider } from 'react-router-dom';

test('PostEmployee component text test', async () => {
    const router = createMemoryRouter([{path: '*',element:<PostEmployee/>}])
    render(<RouterProvider router={router} />)
    const specificText = screen.getByText('Post New Employee');
    expect(specificText).toBeInTheDocument();
  });
  