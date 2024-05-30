import Dashboard from "../pages/dashboard/Dashboard";
import { render, screen } from "@testing-library/react";
import { createMemoryRouter, RouterProvider } from 'react-router-dom';
   
test('Dashboard component text test', async () => {
    const router = createMemoryRouter([{path: '*',element:<Dashboard/>}])
    render(<RouterProvider router={router} />)
    const specificText = screen.getByText('Employees');
    expect(specificText).toBeInTheDocument();
  });
